package io.confluent.connect.jdbc.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ParseUtil {

    public static ParseContext parse(String columnValue){
        return new ParseContext(columnValue);
    }

    public static class ParseContext {
        private String table, schema, value;

        public ParseContext(String value){
            this.value = value;
        }

        public ParseContext withSchema(String schema){
            throw new RuntimeException("Schema interpolation not implemented yet");
//            this.schema = schema;
//            return this;
        }

        public ParseContext withTable(String table){
            this.table = table;
            return this;
        }

        public String process(){
            return value.replace("${table}", table)
                        .replace("${schema}", schema);
        }

    }
}
