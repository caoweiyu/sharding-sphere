/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.proxy.listener;

import io.shardingsphere.core.event.ShardingEventBusInstance;
import io.shardingsphere.proxy.config.RuleRegistry;
import io.shardingsphere.transaction.listener.local.LocalTransactionListener;
import io.shardingsphere.transaction.listener.xa.XATransactionListener;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Listener register for Proxy.
 *
 * @author zhangliang
 * @author panjuan
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProxyListenerRegister {
    
    /**
     * Register all listeners.
     *
     * @param ruleRegistry rule registry.
     */
    public static void register(final RuleRegistry ruleRegistry) {
        new LocalTransactionListener().register();
        new XATransactionListener().register();
        ShardingEventBusInstance.getInstance().register(ruleRegistry);
    }
}
