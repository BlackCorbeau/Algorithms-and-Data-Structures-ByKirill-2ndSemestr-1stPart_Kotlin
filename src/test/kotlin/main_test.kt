import SimpleTest

import org.testng.TestListenerAdapter
import org.testng.TestNG

fun main() {
    val testNG = TestNG()

    testNG.setTestClasses(arrayOf(
        SimpleTest::class.java,
        ))

    val listener = TestListenerAdapter()
    testNG.addListener(listener)

    testNG.run()
}
