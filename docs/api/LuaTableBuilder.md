
### put
+ **Description**:  增加一个键值对.
+ **Return Type**: **LuaTableBuilder<T>**
+ **Return Desc**: 本实例对象.
+ **Usage**: `put(key:String, value:Object)`

|Name|Type|Description|
|-|-|-|
|key|**String**|LuaTable中的键名.|
|value|**Object**|键名对应的值.|
### putAll
+ **Description**:  通过Map增加多个键值对.
+ **Return Type**: **LuaTableBuilder<T>**
+ **Return Desc**: 本实例对象.
+ **Usage**: `putAll(String:Map<?extends, map:?>)`

|Name|Type|Description|
|-|-|-|
|String|**Map<?extends**|null|
|map|**?>**|键为字符串类型的map.|
### clear
+ **Description**:  清空当前表.
+ **Return Type**: **LuaTableBuilder<T>**
+ **Return Desc**: 本实例对象.
+ **Usage**: `clear()`

|Name|Type|Description|
|-|-|-|

### remove
+ **Description**:  移除指定键的值.
+ **Return Type**: **LuaTableBuilder<T>**
+ **Return Desc**: 本实例对象.
+ **Usage**: `remove(key:String)`

|Name|Type|Description|
|-|-|-|
|key|**String**|要移除的键名.|
### build
+ **Description**:  建立Lua中的表.
+ **Return Type**: **T**
+ **Return Desc**: 返回所建立的表.
+ **Usage**: `build()`

|Name|Type|Description|
|-|-|-|

### buildGlobal
+ **Description**:  建立Lua中的表, 并加入到当前环境的全局变量中.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `buildGlobal(key:String)`

|Name|Type|Description|
|-|-|-|
|key|**String**|全局变量的变量名.|