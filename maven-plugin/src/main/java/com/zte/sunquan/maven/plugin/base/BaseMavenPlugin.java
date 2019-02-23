package com.zte.sunquan.maven.plugin.base;

import java.util.List;
import java.util.Map;

import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.rtinfo.RuntimeInformation;
import org.sonatype.plexus.build.incremental.BuildContext;

import com.google.common.collect.Maps;

/**
 * BaseMavenPlugin class
 *
 * @author 10184538
 * @date 2019/2/23
 */
public class BaseMavenPlugin {
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
    }
}
