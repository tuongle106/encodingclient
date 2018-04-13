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
    private static final String JSON_ENCODING_FORMAT = "json";

    @PostMapping(value = "notifications/encoding/notify")
    public void notifyCallback(@RequestParam(JSON_ENCODING_FORMAT) final String json) {
        LOGGER.info("notifyCallback: {}", json);
    }

    @PostMapping(value = "notifications/encoding/error")
    public void notifyCallbackError(@RequestParam(JSON_ENCODING_FORMAT) final String json) {
        LOGGER.info("notifyCallbackError: {}", json);
    }

    @PostMapping(value = "notifications/encoding/upload")
    public void notifyCallbackUpload(@RequestParam(JSON_ENCODING_FORMAT) final String json) {
        LOGGER.info("notifyCallbackUpload: {}", json);
    }

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        String encoded = "{\"result\":{\"mediaid\":\"167461400\",\"taskid\":\"576667049\",\"destination\":\"http:\\/\\/AKIAISOZSGN3XXLJYCTA:QrajP2X9eczVTAo847hBTlw9m9h22F86l1UR06%2Fd@vamvideos.s3.amazonaws.com\\/hls\\/2018\\/04\\/13\\/Justin%2BBieber%2B-%2BOne%2BTime_576667049-0.m3u8\",\"status\":\"Saved\"}}";
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
