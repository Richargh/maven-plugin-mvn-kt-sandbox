package de.richargh.sandbox

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugins.annotations.Mojo

@Mojo(name = "sayhi")
class BuildMojo: AbstractMojo() {

    @Throws(MojoExecutionException::class)
    override fun execute() {
        log.info("Hi, world!");
    }
}