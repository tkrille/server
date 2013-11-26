/*
 * Copyright 2013
 *     tarent AG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.osiam.resources.helper;

import org.osiam.storage.entities.UserEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserFilterParser implements FilterParser<UserEntity> {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public FilterChain<UserEntity> parse(String filterString) {
        if (UserCombinedFilterChain.COMBINED_FILTER_CHAIN.matcher(filterString).matches()) {
            return new UserCombinedFilterChain(this, filterString);
        }
        return new UserSimpleFilterChain(entityManager, filterString);

    }
}