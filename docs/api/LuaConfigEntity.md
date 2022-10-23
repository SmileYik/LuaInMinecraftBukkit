
### getLuaConfig
+ **Description**:  如果需要自己的实体类能够有运行闭包的能力, 则可以用实体类实现本接口, 获取正在配置该 实体类的LuaConfig, 并且利用其运行脚本 所返回出来的闭包.
+ **Return Type**: **LuaConfig**
+ **Return Desc**: 
+ **Usage**: `getLuaConfig()`

|Name|Type|Description|
|-|-|-|

### setLuaConfig
+ **Description**:  设置 LuaConfig.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `setLuaConfig(luaConfig:LuaConfig)`

|Name|Type|Description|
|-|-|-|
|luaConfig|**LuaConfig**|要传入的LuaConfig实例.|