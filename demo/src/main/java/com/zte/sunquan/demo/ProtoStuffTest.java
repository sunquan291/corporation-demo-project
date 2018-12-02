//package com.zte.sunquan.demo;
//
//import com.zte.sdn.oscp.commons.serialize.bean.UserInfo;
//import com.zte.sdn.oscp.commons.serialize.bean.UserInfoUtils;
//import io.protostuff.CollectionSchema;
//import io.protostuff.LinkedBuffer;
//import io.protostuff.MessageCollectionSchema;
//import io.protostuff.MessageMapSchema;
//import io.protostuff.ProtostuffIOUtil;
//import io.protostuff.Schema;
//import io.protostuff.runtime.RuntimeSchema;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by 10176706 on 2017/2/14.
// */
//public class ProtoStuffTest {
//    @SuppressWarnings("unchecked")
//    public static <T> byte[] serialize(T obj) {
//        Class<T> cls = (Class<T>) obj.getClass();
//        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
//        try {
//            Schema<T> schema = getSchema(cls);
//            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
//        } catch (Exception e) {
//            throw new IllegalStateException(e.getMessage(), e);
//        } finally {
//            buffer.clear();
//        }
//    }
//
//    public static <T> T deserialize(byte[] data, Class<T> cls) {
//        try {
//            Schema<T> schema = getSchema(cls);
//            T instance = schema.newMessage();
//            ProtostuffIOUtil.mergeFrom(data, instance, schema);
//            return instance;
//        } catch (Exception e) {
//            throw new IllegalStateException(e.getMessage(), e);
//        }
//    }
//
//    private static <T> Schema<T> getSchema(Class<T> cls) {
//        return RuntimeSchema.getSchema(cls);
//    }
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @Test
//    public void serialize() throws Exception {
//        List<UserInfo> userInfoList = UserInfoUtils.createData(1);
//        UserInfo userInfo1 = userInfoList.get(0);
//        byte[] data = serialize(userInfo1);
//        //System.out.println("size: " + data.length);
//        UserInfo userInfo2 = deserialize(data, UserInfo.class);
//        assertEquals(userInfo1, userInfo2);
//    }
//
//    @Test
//    public void deserialize() throws Exception {
//        List<UserInfo> userInfoList = UserInfoUtils.createData(10);
//        Schema<UserInfo> schema = getSchema(UserInfo.class);
//        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ProtostuffIOUtil.writeListTo(outputStream, userInfoList, schema, buffer);
//        byte[] data = outputStream.toByteArray();
//        //System.out.println("size: " + data.length);
//
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
//        List<UserInfo> userInfo2List = ProtostuffIOUtil.parseListFrom(inputStream, getSchema(UserInfo.class));
//
//        assertEquals(userInfoList.size(), userInfo2List.size());
//        for (UserInfo userInfo : userInfo2List)
//            Assert.assertTrue(userInfoList.contains(userInfo));
//    }
//
//    @Test
//    public void serializeCollection() throws Exception {
//        List<UserInfo> userInfoList = UserInfoUtils.createData(10);
//        Schema<UserInfo> schema = getSchema(UserInfo.class);
//        CollectionSchema<UserInfo> collectionSchema = new MessageCollectionSchema<>(schema);
//        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
//        byte[] data = ProtostuffIOUtil.toByteArray(userInfoList, collectionSchema, buffer);
//        //System.out.println("size: " + data.length);
//
//        Collection<UserInfo> userInfoArrayList = collectionSchema.newMessage();
//        ProtostuffIOUtil.mergeFrom(data, userInfoArrayList, collectionSchema);
//        assertEquals(userInfoList.size(), userInfoArrayList.size());
//        for (UserInfo userInfo : userInfoArrayList)
//            Assert.assertTrue(userInfoList.contains(userInfo));
//    }
//
//    @Test
//    public void serializeArray() throws Exception {
//        List<UserInfo> userInfoList = UserInfoUtils.createData(10);
//        UserInfo[] userInfoArray = userInfoList.toArray(new UserInfo[0]);
//
//        //System.out.println("class: " + userInfoArray.getClass());
//        Schema<UserInfo> schema = getSchema(UserInfo.class);
//        CollectionSchema<UserInfo> collectionSchema = new MessageCollectionSchema<>(schema);
//        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
//        byte[] data = ProtostuffIOUtil.toByteArray(Arrays.asList(userInfoArray), collectionSchema, buffer);
//        //System.out.println("size: " + data.length);
//
//        Collection<UserInfo> userInfo2 = collectionSchema.newMessage();
//        ProtostuffIOUtil.mergeFrom(data, userInfo2, collectionSchema);
//        assertEquals(userInfoArray.length, userInfo2.size());
//        for (int i = 0; i < userInfoArray.length; i++) {
//            assertTrue(userInfo2.contains(userInfoArray[i]));
//        }
//    }
//
//    @Test
//    public void serializeMap() throws Exception {
//        List<UserInfo> userInfoList = UserInfoUtils.createData(10);
//        Map<String, UserInfo> userInfoMap = new HashMap<>();
//        Schema<UserInfo> userInfoSchema = getSchema(UserInfo.class);
//        Schema<String> schema = getSchema(String.class);
//        MessageMapSchema<String, UserInfo> mapSchema = new MessageMapSchema<String, UserInfo>(schema, userInfoSchema);
//        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
//        byte[] data = ProtostuffIOUtil.toByteArray(userInfoMap, mapSchema, buffer);
//        //System.out.println("size: " + data.length);
//        Map<String, UserInfo> userInfoMap2 = mapSchema.newMessage();
//        ProtostuffIOUtil.mergeFrom(data, userInfoMap2, mapSchema);
//        Assert.assertNotNull(userInfoMap2);
//        Assert.assertTrue(userInfoMap2.isEmpty());
//
//        for (UserInfo userInfo : userInfoList) {
//            userInfoMap.put(userInfo.getName(), userInfo);
//        }
//
//        data = ProtostuffIOUtil.toByteArray(userInfoMap, mapSchema, buffer);
//        //System.out.println("size: " + data.length);
//
//        userInfoMap2 = mapSchema.newMessage();
//        ProtostuffIOUtil.mergeFrom(data, userInfoMap2, mapSchema);
//        assertEquals(userInfoMap.size(), userInfoMap2.size());
//        for (Map.Entry<String, UserInfo> entry : userInfoMap.entrySet()) {
//            UserInfo userInfo = userInfoMap2.get(entry.getKey());
//            Assert.assertNotNull(userInfo);
//            assertEquals(userInfo, entry.getValue());
//        }
//    }
//
//    @Test
//    public void testByte() {
//        byte[] data = serialize(new Integer(1));
//        int result = deserialize(data, Integer.class);
//        assertEquals(1, result);
//        Object obj = data;
//        assertTrue(byte[].class.isAssignableFrom(obj.getClass()));
//
//    }
//
//    @Test
//    public void testInt() {
//        byte[] data = new ProtoStuffBinarySerializer().serialize(1);
//        int result = new ProtoStuffBinaryDeserializer().deserialize(data, Integer.class);
//        assertEquals(1, result);
//    }
//
//    @Test
//    public void testEnum() {
//        Type ins = Type.A;
//        byte[] data = new ProtoStuffBinarySerializer().serialize(ins);
//        Type result = new ProtoStuffBinaryDeserializer().deserialize(data, Type.class);
//        assertEquals(ins.name(), result.name());
//    }
//
//    @Test
//    public void testArrayClass() {
//        Class cls = String[].class;
//        Class ccls = cls.getComponentType();
//        assertTrue(cls.isArray());
//        assertEquals(ccls, String.class);
//
//        UserInfo[] userInfoList = UserInfoUtils.createData(10).toArray(new UserInfo[0]);
//        byte[] data = new ProtoStuffBinarySerializer().serializeArray(userInfoList);
//        UserInfo[] result = new ProtoStuffBinaryDeserializer().deserializeArray(data, UserInfo[].class);
//        assertNotNull(result);
//        for (int i = 0; i < userInfoList.length; i++) {
//            assertEquals(result[i], userInfoList[i]);
//        }
//
//        long[] longs = {1L, 10L, 100L, 1000L, 10000L};
//        data = new ProtoStuffBinarySerializer().serializeArray(longs);
//        long[] resultL = new ProtoStuffBinaryDeserializer().deserializeArray(data, long[].class);
//        assertNotNull(resultL);
//        for (int i = 0; i < longs.length; i++) {
//            assertEquals(resultL[i], longs[i]);
//        }
//    }
//
//    enum Type {
//        A, B, C;
//    }
//
//}