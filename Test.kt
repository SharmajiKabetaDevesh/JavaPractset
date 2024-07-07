
import java.io.DataOutputStream
import java.io.File
import java.io.FileInputStream
import java.net.HttpURLConnection
import java.net.URL
class Test {
    private fun uploadImage(imageFile: File) {
        val url = URL("http://127.0.0.1:3001/analyze")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.doOutput = true
        connection.setRequestProperty("Content-Type", "image/jpeg")

        try {
            val outputStream = DataOutputStream(connection.outputStream)
            val fileInputStream = FileInputStream(imageFile)
            val buffer = ByteArray(1024)
            var bytesRead: Int
            while (fileInputStream.read(buffer).also { bytesRead = it } != -1) {
                outputStream.write(buffer, 0, bytesRead)
            }
            fileInputStream.close()
            outputStream.flush()
            outputStream.close()

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Image successfully uploaded
                val inputStream = connection.inputStream
                // Process the response if needed
                inputStream.close()
            } else {
                // Handle upload failure
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle exception
        } finally {
            connection.disconnect()
        }
    }

    fun main(){


    }

}