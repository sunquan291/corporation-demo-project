package com.zte.sunquan.plugin;

import com.google.common.collect.Maps;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.rtinfo.RuntimeInformation;
import org.sonatype.plexus.build.incremental.BuildContext;

import java.util.List;
import java.util.Map;

/**
 * Created by 10184538 on 2017/6/7.
 */
public class BaseMavenPlugin extends AbstractMojo {
    public MavenPluginInfo pluginInfo;
    @Parameter(property = "basedir", defaultValue = "${basedir}")
    protected String baseDir;
    @Parameter(property = "resources", defaultValue = "${project.build.resources}")
    protected String resources;
    @Parameter(property = "outDirectory", defaultValue = "${project.build.outputDirectory}")
    protected String outDirectory;
    @Parameter(property = "testResources", defaultValue = "${project.build.testResources}")
    protected String testResources;
    @Parameter(property = "testOutDirectory", defaultValue = "${project.build.testOutputDirectory}")
    protected String testOutDirectory;
    @Parameter(property = "project", required = true, readonly = true,
            defaultValue = "${project}")
    protected MavenProject project;
    @Parameter(readonly = true, defaultValue = "${localRepository}")
    protected ArtifactRepository localRepository;
    @Parameter(readonly = true, defaultValue = "${project.remoteArtifactRepositories}")
    protected List<ArtifactRepository> remoteRepository;
    @Component
    protected RuntimeInformation runtime;
    @Component
    protected BuildContext context;

    public void execute() throws MojoExecutionException, MojoFailureException {
        pluginInfo = new MavenPluginInfo(baseDir, resources, outDirectory,
                testResources, testOutDirectory, project,
                localRepository, remoteRepository, runtime, context);
    }

    class MavenPluginInfo {
        protected String baseDir;
        protected String resources;
        protected String outDirectory;
        protected String testResources;
        protected String testOutDirectory;
        protected MavenProject project;
        protected ArtifactRepository localRepository;
        protected List<ArtifactRepository> remoteRepository;
        protected RuntimeInformation runtime;
        protected BuildContext context;
        protected Map<String, String> configuration = Maps.newConcurrentMap();

        public MavenPluginInfo(String baseDir, String resources, String outDirectory, String testResources, String testOutDirectory, MavenProject project, ArtifactRepository localRepository, List<ArtifactRepository> remoteRepository, RuntimeInformation runtime, BuildContext context) {
            this.baseDir = baseDir;
            this.resources = resources;
            this.outDirectory = outDirectory;
            this.testResources = testResources;
            this.testOutDirectory = testOutDirectory;
            this.project = project;
            this.localRepository = localRepository;
            this.remoteRepository = remoteRepository;
            this.runtime = runtime;
            this.context = context;
        }

        public String getBaseDir() {
            return baseDir;
        }

        public void setBaseDir(String baseDir) {
            this.baseDir = baseDir;
        }

        public String getResources() {
            return resources;
        }

        public void setResources(String resources) {
            this.resources = resources;
        }

        public String getOutDirectory() {
            return outDirectory;
        }

        public void setOutDirectory(String outDirectory) {
            this.outDirectory = outDirectory;
        }

        public String getTestResources() {
            return testResources;
        }

        public void setTestResources(String testResources) {
            this.testResources = testResources;
        }

        public String getTestOutDirectory() {
            return testOutDirectory;
        }

        public void setTestOutDirectory(String testOutDirectory) {
            this.testOutDirectory = testOutDirectory;
        }

        public MavenProject getProject() {
            return project;
        }

        public void setProject(MavenProject project) {
            this.project = project;
        }

        public ArtifactRepository getLocalRepository() {
            return localRepository;
        }

        public void setLocalRepository(ArtifactRepository localRepository) {
            this.localRepository = localRepository;
        }

        public List<ArtifactRepository> getRemoteRepository() {
            return remoteRepository;
        }

        public void setRemoteRepository(List<ArtifactRepository> remoteRepository) {
            this.remoteRepository = remoteRepository;
        }

        public RuntimeInformation getRuntime() {
            return runtime;
        }

        public void setRuntime(RuntimeInformation runtime) {
            this.runtime = runtime;
        }

        public BuildContext getContext() {
            return context;
        }

        public void setContext(BuildContext context) {
            this.context = context;
        }

        public Map<String, String> getConfiguration() {
            return configuration;
        }

        public void setConfiguration(Map<String, String> configuration) {
            this.configuration = configuration;
        }

        public String getConfiguration(String key) {
            return this.configuration.get(key);
        }

        public void addConfiguration(String key, String value) {
            this.configuration.put(key, value);
        }
    }

}
