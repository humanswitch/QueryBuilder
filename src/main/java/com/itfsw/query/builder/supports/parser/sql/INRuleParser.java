/*
 * Copyright (c) 2017.
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
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.itfsw.query.builder.supports.parser.sql;

import com.itfsw.query.builder.supports.model.IRule;
import com.itfsw.query.builder.supports.model.enums.EnumOperator;
import com.itfsw.query.builder.supports.model.sql.Operation;
import com.itfsw.query.builder.supports.parser.AbstractSqlRuleParser;

import java.util.List;

/**
 * ---------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------
 * @author: hewei
 * @time:2017/11/1 10:46
 * ---------------------------------------------------------------------------
 */
public class INRuleParser extends AbstractSqlRuleParser {
    public Operation parse(IRule rule) {
        StringBuffer operate = new StringBuffer(rule.getField());
        operate.append(" IN (");

        List<Object> value = (List<Object>) rule.getValue();

        for (int i = 0; i < value.size(); i++){
            operate.append("?");
            if (i < value.size() - 1){
                operate.append(", ");
            }
        }

        operate.append(")");

        return new Operation(operate, rule.getValue());
    }

    public boolean canParse(IRule rule) {
        return EnumOperator.IN.value().equals(rule.getOperator());
    }
}
