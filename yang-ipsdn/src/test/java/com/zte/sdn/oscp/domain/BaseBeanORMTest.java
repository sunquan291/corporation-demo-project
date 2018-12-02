package com.zte.sdn.oscp.domain;

import com.zte.sdn.oscp.commons.utils.Environment;
import com.zte.sdn.oscp.framework.service.annotations.Service;
import com.zte.sdn.oscp.framework.test.ServiceTestBase;
import com.zte.sdn.oscp.persistence.entity.EntityHelper;
import com.zte.sdn.oscp.persistence.entity.EntityManager;
import com.zte.sdn.oscp.persistence.entity.EntityManagerFactory;
import com.zte.sdn.oscp.persistence.entity.EntityMetaData;
import com.zte.sdn.oscp.persistence.entity.impl.EntityManagerFactoryImpl;
import com.zte.sdn.oscp.persistence.exceptions.EntityException;
import com.zte.sdn.oscp.persistence.exceptions.TableException;
import com.zte.sdn.oscp.persistence.model.Table;
import com.zte.sdn.oscp.persistence.model.TableManager;
import com.zte.sdn.oscp.persistence.model.impl.TableManagerImpl;
import com.zte.sdn.oscp.persistence.service.jdbc.DatabaseConnectionFactory;
import com.zte.sdn.oscp.persistence.service.jdbc.impl.DatabaseConnectionFactoryImpl;
import com.zte.sdn.oscp.persistence.validator.exceptions.DataValidateException;
import com.zte.sdn.oscp.yangutil.table.TestEntityBase;
import org.junit.Assert;

import java.util.List;

/**
 * Created by 10184538 on 2017/6/15.
 */
public class BaseBeanORMTest extends ServiceTestBase {
    @Service
    protected EntityManagerFactory entityManagerFactory = null;


    @Override
    public void initialize() {
        if (!isInitFinished()) {
            logger.info("{} initialize.", this.getClass());
            Environment.setModuleEnabled("test", true);
            Environment.setHomePath(BaseBeanORMTest.class);

            DatabaseConnectionFactoryImpl databaseConnectionFactory = new DatabaseConnectionFactoryImpl();
            this.addService(DatabaseConnectionFactory.class, databaseConnectionFactory);
            databaseConnectionFactory.initialize();
            databaseConnectionFactory.start();

            TableManagerImpl tableManager = new TableManagerImpl(this);
            this.addService(TableManager.class, tableManager);
            tableManager.initialize();

            EntityManagerFactoryImpl entityManagerFactory = new EntityManagerFactoryImpl(this);
            this.addService(EntityManagerFactory.class, entityManagerFactory);
            entityManagerFactory.initialize();
            this.entityManagerFactory = entityManagerFactory;
        }
    }

    protected EntityManager getEntityManager() {
        return entityManagerFactory.open();
    }

    protected void createTable(Table table) throws TableException {
        if (table.exists())
            table.drop();

        table.create();
    }

    protected void saveDomain(Object object) {
        try {
            this.getEntityManager().save(object);
        } catch (EntityException e) {
            e.printStackTrace();
        } catch (DataValidateException e) {
            e.printStackTrace();
        }
    }

    protected <T> List<T> loadDomain(Class<T> cls) {
        List<T> result = null;
        try {
            result = this.getEntityManager().load(cls);

        } catch (EntityException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected void dropTable(Table table) throws TableException {
        table.drop();
        Assert.assertFalse(table.exists());
    }

    protected Table getTable(Class cls) {
        Table table = null;
        EntityMetaData entityMetaData = EntityHelper.getEntityMetaData(cls);
        if (entityMetaData != null)
            table = entityMetaData.getTable();
        return table;
    }
}
