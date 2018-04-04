/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.sample.login.application.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class APIController {
    private static final Logger LOGGER = LoggerFactory.getLogger(APIController.class);

    @PostMapping(value = "media/callback/notify")
    public void notifyCallback(@RequestBody String json) {
        LOGGER.info("notifyCallback: {}", json);
    }

    @PostMapping(value = "media/callback/error")
    public void notifyCallbackError(@RequestBody String json) {
        LOGGER.info("notifyCallbackError: {}", json);
    }

    @PostMapping(value = "media/callback/upload")
    public void notifyCallbackUpload(@RequestBody String json) {
        LOGGER.info("notifyCallbackUpload: {}", json);
    }

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        String encoded = "%7B%22result%22%3A%7B%22mediaid%22%3A%22166112948%22%2C%22source%22%3A%22https%3A%5C%2F%5C%2Fvamvideos.s3.amazonaws.com%5C%2F2018%5C%2F02%5C%2F06%5C%2Fstep.mov%22%2C%22status%22%3A%22Error%22%2C%22description%22%3A%22No+tasks+are+completed%22%2C%22encodinghost%22%3A%22http%3A%5C%2F%5C%2Fmanage.encoding.com%5C%2F%22%2C%22format%22%3A%7B%22taskid%22%3A%22572462435%22%2C%22output%22%3A%22advanced_hls%22%2C%22status%22%3A%22Error%22%2C%22description%22%3A%22ECOM00269%3A+Audio+extraction+failed%22%2C%22suggestion%22%3A%22Our+decoder+could+not+extract+audio+stream+from+your+source+file.+%22%7D%7D%7D";
        try {
            String decoded = URLDecoder.decode(encoded, "UTF-8");
            System.out.print("S2: " + decoded);
            EncodingResult encodingResult = objectMapper.readValue(decoded, EncodingResult.class);
            System.out.print("S2 Object: " + encodingResult);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
