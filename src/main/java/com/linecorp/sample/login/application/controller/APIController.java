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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class APIController {
    private static final Logger LOGGER = LoggerFactory.getLogger(APIController.class);

    @PostMapping(value = "notifications/encoding/notify")
    public void notifyCallback(@RequestParam("json") final EncodingResult json) {
        LOGGER.info("notifyCallback: {}", json);
    }

    @PostMapping(value = "notifications/encoding/error")
    public void notifyCallbackError(@RequestParam("json") final EncodingResult json) {
        LOGGER.info("notifyCallbackError: {}", json);
    }

    @PostMapping(value = "notifications/encoding/upload")
    public void notifyCallbackUpload(@RequestParam("json") final EncodingResult json) {
        LOGGER.info("notifyCallbackUpload: {}", json);
    }

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        String encoded = "%7B%22result%22%3A%7B%22mediaid%22%3A%22167456906%22%2C%22taskid%22%3A%22576606884%22%2C%22destination%22%3A%22http%3A%5C%2F%5C%2FAKIAISOZSGN3XXLJYCTA%3AQrajP2X9eczVTAo847hBTlw9m9h22F86l1UR06%252Fd%40vamvideos.s3.amazonaws.com%5C%2Fhls%5C%2F2018%5C%2F04%5C%2F13%5C%2FJustin%252BBieber%252B-%252BOne%252BTime_576606884-0.m3u8%22%2C%22status%22%3A%22Saved%22%7D%7D";
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
