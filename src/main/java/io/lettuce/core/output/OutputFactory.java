/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core.output;

import java.util.*;

/**
 * @author Mark Paluch
 */
public class OutputFactory {

    public static <T> List<T> newList(int capacity) {

        if (capacity < 1) {
            return Collections.emptyList();
        }

        return new ArrayList<>(Math.max(1, capacity));
    }

    public static <V> Set<V> newSet(int capacity) {

        if (capacity < 1) {
            return Collections.emptySet();
        }

        return new LinkedHashSet<>(capacity, 1);
    }
}
