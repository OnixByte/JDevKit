/*
 * Copyright (C) 2023 CodeCraftersCN.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.org.codecrafters.simplejwt;

import java.time.Duration;
import java.util.Map;

/**
 * TokenResolver
 *
 * @author Zihlu Wang
 * @since 29 Jul 2023
 */
public interface TokenResolver {

    String createToken(Duration expireAfter, String audience);

    String createToken(Duration expireAfter, String audience, Map<String, Object> payloads);

    <T extends TokenPayload> String createToken(Duration expireAfter, String audience, T payloads);

    String createToken(Duration expireAfter, String subject, String audience);

    String createToken(Duration expireAfter, String subject, String audience, Map<String, Object> payloads);

    <T extends TokenPayload> String createToken(Duration expireAfter, String subject, String audience, T payloads);

    Map<String, Object> extract(String token);

    <T extends TokenPayload> T extract(String token, Class<T> targetType);
    
    String renew(String oldToken);
    
    String renew(String oldToken, Map<String, Object> payloads);

    <T extends TokenPayload> String renew(String oldToken, T payloads);

    <T> ResolvedToken<T> resolve(String token);

}
