//package uz.uzcard.services.student.config;
//
//
//import com.google.common.io.CharStreams;
//import com.google.gson.Gson;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import org.springframework.http.HttpStatus;
//import uz.uzcard.service.dbservice.dto.ApiResponse;
//import uz.uzcard.services.student.exception.RestException;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.nio.charset.StandardCharsets;
//
///**
// * Feign dan kelgan exception larni o'qib olish uchun yaratilgan CustomErrorDecoder class.
// */
//public class CustomErrorDecoder implements ErrorDecoder {
//    @Override
//    public Exception decode(String methodKey, Response response) {
//        String message = null;
//        Reader reader = null;
//
//        try {
//            reader = response.body().asReader(StandardCharsets.UTF_8);
//            //Easy way to read the stream and get a String objectresponse = {Response@14903} "HTTP/1.1 500\ncache-control: no-cache, no-store, max-age=0, must-revalidate\nconnection: close\ncontent-type: application/json\ndate: Sat, 11 Dec 2021 12:01:10 GMT\nexpires: 0\npragma: no-cache\ntransfer-encoding: chunked\nvary: Access-Control-Request-Headers\nvary: Access-Control-Request-Method\nvary: Origin\nx-content-type-options: nosniff\nx-frame-options: DENY\nx-xss-protection: 1; mode=block\n\nfeign.Response$InputStreamBody@79af1e86"… View
//            //Stream o'qish va String ob'ektini olishning oson usuli
//
//            message = CharStreams.toString(reader);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            //It is the responsibility of the caller to close the stream.
//            try {
//                if (reader != null)
//                    reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        Gson gson = new Gson();
//        ApiResponse<?> apiResult = gson.fromJson(message, ApiResponse.class);
//        return new RestException(HttpStatus.valueOf(response.status()), String.valueOf(apiResult.getErrors()));
//    }
//}
