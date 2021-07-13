@file:Suppress("unused")

package dev.mwhyte.function

import com.google.cloud.functions.HttpFunction
import com.google.cloud.functions.HttpRequest
import com.google.cloud.functions.HttpResponse
import mu.KotlinLogging
import java.io.IOException

class App : HttpFunction {

    private val logger = KotlinLogging.logger {}

    @Throws(IOException::class)
    override fun service(request: HttpRequest, response: HttpResponse) {
        logger.info { "hello world" }
        response.writer.write("FUNCTION COMPLETE")
    }
}
