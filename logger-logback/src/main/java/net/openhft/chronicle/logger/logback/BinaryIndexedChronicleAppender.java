/*
 * Copyright 2014 Higher Frequency Trading
 *
 * http://www.higherfrequencytrading.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.chronicle.logger.logback;

import ch.qos.logback.core.joran.spi.DefaultClass;
import net.openhft.chronicle.logger.ChronicleLogWriter;
import net.openhft.chronicle.logger.ChronicleLogWriters;
import net.openhft.chronicle.logger.IndexedLogAppenderConfig;

import java.io.IOException;

public class BinaryIndexedChronicleAppender extends AbstractBinaryChronicleAppender {
    private IndexedLogAppenderConfig config;

    public BinaryIndexedChronicleAppender() {
        this.config = new IndexedLogAppenderConfig();
    }

    @DefaultClass(value = IndexedLogAppenderConfig.class)
    public void setChronicleConfig(final IndexedLogAppenderConfig config) {
        this.config = config;
    }

    public IndexedLogAppenderConfig getChronicleConfig() {
        return this.config;
    }

    @Override
    protected ChronicleLogWriter createWriter() throws IOException {
        return ChronicleLogWriters.binary(
            this.config,
            this.getPath()
        );
    }
}
