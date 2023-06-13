
### getClass
+ **Description**:  通过全类名去获取java类类型.
+ **Return Type**: **Class<?>**
+ **Return Desc**: 如果类存在则返回对应的类
+ **Usage**: `getClass(name:String)`

|Name|Type|Description|
|-|-|-|
|name|**String**|全类名|
### toIntArray
+ **Description**:  将Lua中只含整形的表转换为java中的整形数组.
+ **Return Type**: **int[]**
+ **Return Desc**: 转换成Java中的整形数组.
+ **Usage**: `toIntArray(table:LuaObject)`

|Name|Type|Description|
|-|-|-|
|table|**LuaObject**|只含整形的表（数组）.|
### toIntArray
+ **Description**:  将Lua中只含整形的表转换为java中的整形数组.
+ **Return Type**: **int[]**
+ **Return Desc**: 转换成Java中的整形数组.
+ **Usage**: `toIntArray(table:LuaTable)`

|Name|Type|Description|
|-|-|-|
|table|**LuaTable**|只含整形的表（数组）.|
### toDoubleArray
+ **Description**:  将Lua中只含浮点数的表转换为java中的double类型数组.
+ **Return Type**: **double[]**
+ **Return Desc**: 转换成Java中的double类型数组.
+ **Usage**: `toDoubleArray(table:LuaObject)`

|Name|Type|Description|
|-|-|-|
|table|**LuaObject**|只含小数的表（数组）.|
### toDoubleArray
+ **Description**:  将Lua中只含浮点数的表转换为java中的double类型数组.
+ **Return Type**: **double[]**
+ **Return Desc**: 转换成Java中的double类型数组.
+ **Usage**: `toDoubleArray(table:LuaTable)`

|Name|Type|Description|
|-|-|-|
|table|**LuaTable**|只含小数的表（数组）.|
### toFloatArray
+ **Description**:  将Lua中只含浮点数的表转换为java中的float类型数组.
+ **Return Type**: **float[]**
+ **Return Desc**: 转换成Java中的float类型数组.
+ **Usage**: `toFloatArray(table:LuaObject)`

|Name|Type|Description|
|-|-|-|
|table|**LuaObject**|只含小数的表（数组）.|
### toFloatArray
+ **Description**:  将Lua中只含浮点数的表转换为java中的float类型数组.
+ **Return Type**: **float[]**
+ **Return Desc**: 转换成Java中的float类型数组.
+ **Usage**: `toFloatArray(table:LuaTable)`

|Name|Type|Description|
|-|-|-|
|table|**LuaTable**|只含小数的表（数组）.|
### toStringArray
+ **Description**:  将Lua中只含字符串的表转换为java中的String类型数组.
+ **Return Type**: **String[]**
+ **Return Desc**: 转换成Java中的String类型数组.
+ **Usage**: `toStringArray(table:LuaObject)`

|Name|Type|Description|
|-|-|-|
|table|**LuaObject**|只含字符串的表（数组）.|
### toStringArray
+ **Description**:  将Lua中只含字符串的表转换为java中的String类型数组.
+ **Return Type**: **String[]**
+ **Return Desc**: 转换成Java中的String类型数组.
+ **Usage**: `toStringArray(table:LuaTable)`

|Name|Type|Description|
|-|-|-|
|table|**LuaTable**|只含字符串的表（数组）.|
### toArray
+ **Description**:  将Lua中只含指定类型的表转换为java中的指定类型数组.
+ **Return Type**: **T[]**
+ **Return Desc**: 转换成Java中的指定类型数组.
+ **Usage**: `toArray(t:T, table:LuaObject)`

|Name|Type|Description|
|-|-|-|
|t|**T**|需要转换成的Java类型实例.|
|table|**LuaObject**|只含指定类型的表（数组）.|
### toArray
+ **Description**:  将Lua中只含指定类型的表转换为java中的指定类型数组.
+ **Return Type**: **T[]**
+ **Return Desc**: 转换成Java中的指定类型数组.
+ **Usage**: `toArray(t:T, table:LuaTable)`

|Name|Type|Description|
|-|-|-|
|t|**T**|需要转换成的Java类型实例.|
|table|**LuaTable**|只含指定类型的表（数组）.|
### toObjectArray
+ **Description**:  将Lua中的表(数组)转换为java中的Object类型数组.
+ **Return Type**: **Object[]**
+ **Return Desc**: @return
+ **Usage**: `toObjectArray(table:LuaObject)`

|Name|Type|Description|
|-|-|-|
|table|**LuaObject**|表（数组）|
### toObjectArray
+ **Description**:  将Lua中的表(数组)转换为java中的Object类型数组.
+ **Return Type**: **Object[]**
+ **Return Desc**: @return
+ **Usage**: `toObjectArray(table:LuaTable)`

|Name|Type|Description|
|-|-|-|
|table|**LuaTable**|表（数组）|
### toStringStringMap
+ **Description**:  将Lua中的只包含字符串的数组（下标为数字且未显式指定数字下标的Table）（如{"a", "b"}而非{2 = "b"}）转换为Java中的Map类型.
+ **Return Type**: **Map<String, String>**
+ **Return Desc**: Map<String, String>类型HashMap.
+ **Usage**: `toStringStringMap(table:LuaObject)`

|Name|Type|Description|
|-|-|-|
|table|**LuaObject**|Lua中的表|
### toStringStringMap
+ **Description**:  将Lua中的只包含字符串的数组（下标为数字且未显式指定数字下标的Table）（如{"a", "b"}而非{2 = "b"}）转换为Java中的Map类型.
+ **Return Type**: **Map<String, String>**
+ **Return Desc**: Map<String, String>类型HashMap.
+ **Usage**: `toStringStringMap(table:LuaTable)`

|Name|Type|Description|
|-|-|-|
|table|**LuaTable**|Lua中的表|
### toObjectObjectMap
+ **Description**:  将Lua中的数组（下标为数字且未显式指定数字下标的Table）（如{"a", "b"}而非{2 = "b"}）转换为Java中的Map类型.
+ **Return Type**: **Map<Object, Object>**
+ **Return Desc**: Map<Object, Object>类型HashMap.
+ **Usage**: `toObjectObjectMap(table:LuaObject)`

|Name|Type|Description|
|-|-|-|
|table|**LuaObject**|Lua中的表|
### toObjectObjectMap
+ **Description**:  将Lua中的数组（下标为数字且未显式指定数字下标的Table）（如{"a", "b"}而非{2 = "b"}）转换为Java中的Map类型.
+ **Return Type**: **Map<Object, Object>**
+ **Return Desc**: Map<Object, Object>类型HashMap.
+ **Usage**: `toObjectObjectMap(table:LuaTable)`

|Name|Type|Description|
|-|-|-|
|table|**LuaTable**|Lua中的表|