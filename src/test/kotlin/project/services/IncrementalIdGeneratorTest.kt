package project.services

import org.junit.Test
import kotlin.test.assertEquals

class IncrementalIdGeneratorTest {
    @Test
    fun generatesIncrementsIdEveryTimeItsCalled() {
        val generator = IncrementalIdGenerator()
        val first = generator.generate()
        val second = generator.generate()

        assertEquals("1", first)
        assertEquals("2", second)
    }
}