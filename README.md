# Sandbox: Custom Maven Plugin

The Maven lifecycles are describes in the [official docs](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

Writing a custom maven plugin is also described in the [official docs](http://maven.apache.org/guides/plugin/guide-java-plugin-development.html).  

The project is based on [this code from carlosvin](https://github.com/carlosvin/blog-maven-plugin).

## Usage

Install the plugin and immediately execute it with `mvn install de.richargh.sandbox:simple-maven-plugin:sayhi`


## Experience

I find it quite tricky to write a maven plugin in Kotlin for a couple of reasons:

1. Theoretically you can inject `@Parameter` with default values into the Mojo. In Kotlin I don't know how to do that. Constructor injection, lateinit var etc. did not generate the expected results.
2. Testing is incredibly annoying and I could not get it to work with Kotlin and JUnit5.

### Testing

[According to the docs](https://maven.apache.org/plugin-developers/plugin-testing.html) there are at least three ways. The one I hoped would work was the [maven-plugin-testing-harness](https://maven.apache.org/plugin-testing/maven-plugin-testing-harness/getting-started/index.html) but it requires extending a JUnit4 `AbstractMojoTestCase`. I wanted to run the tests with JUnit5 though. So I used Junit Vintage to run the test and then ran into the mentioned injection issues.

I could not find an obvious way (a single method or class) to create `BuildMojo` and supply the properties to inject. Of course I can easily instantiate the class but then I cannot use any of the features that the maven runtime provides. I would have wished there was some Method that allows me to do `runPlugin(BuildMojo::class.java, Environment("parameter1" to 5))`. Having maven plugin development depend on a specific test framework is very annoying.