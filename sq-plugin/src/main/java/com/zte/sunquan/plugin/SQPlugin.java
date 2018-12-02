package com.zte.sunquan.plugin;

import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.rtinfo.RuntimeInformation;
import org.sonatype.plexus.build.incremental.BuildContext;

import java.util.List;

import static org.apache.maven.plugins.annotations.LifecyclePhase.PROCESS_SOURCES;
import static org.apache.maven.plugins.annotations.ResolutionScope.COMPILE;

/**
 * Created by 10184538 on 2017/6/7.
 */
@Mojo(name = "sq-test", defaultPhase = PROCESS_SOURCES,
        requiresDependencyResolution = COMPILE)
public class SQPlugin extends BaseMavenPlugin {
//
//    @Parameter(property = "basedir", defaultValue = "${basedir}")
//    private String baseDir;
//    @Parameter(property = "basedir1", defaultValue = "${project.build.resources}")
//    private String resources;
//    @Parameter(property = "basedir2", defaultValue = "${project.build.outputDirectory}")
//    private String outDirectory;
//    @Parameter(property = "basedir3", defaultValue = "${project.build.testResources}")
//    private String testResources;
//    @Parameter(property = "basedir4", defaultValue = "${project.build.testOutputDirectory}")
//    private String testOutDirectory;
//    @Parameter(property = "project", required = true, readonly = true,
//            defaultValue = "${project}")
//    private MavenProject project;
//    @Parameter(readonly = true, defaultValue = "${localRepository}")
//    private ArtifactRepository localRepository;
//    @Parameter(readonly = true, defaultValue = "${project.remoteArtifactRepositories}")
//    private List<ArtifactRepository> remoteRepository;
//    @Component
//    private RuntimeInformation runtime;
//    @Component
//    private BuildContext context;

    @Parameter(property = "sqConfig", defaultValue = "src/main/sq-config")
    private String sqConfig;

    public void execute() throws MojoExecutionException, MojoFailureException {
        super.execute();
        System.out.println("baseDir:" + pluginInfo.getBaseDir());
//        System.out.println("baseDir:" + baseDir);
//        System.out.println("resources:" + resources);
//        System.out.println("outDirectory:" + outDirectory);
//        System.out.println("testResources:" + testResources);
//        System.out.println("testOutDirectory:" + testOutDirectory);
//        System.out.println("project:" + project);
//        System.out.println("localRepository:" + localRepository);
//        System.out.println("remoteRepository:" + remoteRepository);
//        System.out.println("runtime:" + runtime);
//        System.out.println("maven-version:" + runtime.getMavenVersion());
//        System.out.println("sqConfig:" + sqConfig);

//        baseDir:E:\sunquan-project\demo
//        resources:null
//        outDirectory:E:\sunquan-project\demo\target\classes
//        testResources:null
//        testOutDirectory:E:\sunquan-project\demo\target\test-classes
//        project:MavenProject: com.zte.sunquan.demo:selfstudy:1.0-SNAPSHOT @ E:\sunquan-project\demo\pom.xml
//        localRepository:      id: local
//        url: file:///E:/.m2/repository/
//        layout: default
//        snapshots: [enabled => true, update => always]
//        releases: [enabled => true, update => always]
//
//        remoteRepository:[      id: nexus
//        url: http://10.42.94.46:9999/nexus/content/groups/public
//        layout: default
//        snapshots: [enabled => true, update => always]
//        releases: [enabled => true, update => daily]
//]
//        runtime:org.apache.maven.rtinfo.internal.DefaultRuntimeInformation@796d3c9f
//        maven-version:3.3.9
//        sqConfig:src/main/sq-config2
    }
}
