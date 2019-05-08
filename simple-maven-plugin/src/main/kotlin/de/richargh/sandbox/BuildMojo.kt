package de.richargh.sandbox

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo

@Mojo(name = "sayhi", defaultPhase = LifecyclePhase.COMPILE)
class BuildMojo(): AbstractMojo() {

    @Throws(MojoExecutionException::class)
    override fun execute() {
        log.info("Hello, world!");
    }
}