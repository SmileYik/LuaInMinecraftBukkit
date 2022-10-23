
### self:getId
+ **Description**:  获取脚本插件ID.
+ **Return Type**: **String**
+ **Return Desc**: 插件的id.
+ **Usage**: `self:getId()`

|Name|Type|Description|
|-|-|-|

### self:getDisplayName
+ **Description**:  获取脚本插件的显示名称.
+ **Return Type**: **String**
+ **Return Desc**: 脚本插件的显示名称
+ **Usage**: `self:getDisplayName()`

|Name|Type|Description|
|-|-|-|

### self:getAuthor
+ **Description**:  获取脚本插件的作者.
+ **Return Type**: **String**
+ **Return Desc**: 脚本插件的作者
+ **Usage**: `self:getAuthor()`

|Name|Type|Description|
|-|-|-|

### self:getVersion
+ **Description**:  获取脚本插件的版本.
+ **Return Type**: **String**
+ **Return Desc**: 脚本插件版本.
+ **Usage**: `self:getVersion()`

|Name|Type|Description|
|-|-|-|

### self:getSoftDependents
+ **Description**:  获取脚本插件的非必要依赖脚本插件id.
+ **Return Type**: **List<String>**
+ **Return Desc**: 非必要依赖脚本插件id.
+ **Usage**: `self:getSoftDependents()`

|Name|Type|Description|
|-|-|-|

### self:getDependents
+ **Description**:  获取脚本插件的必要依赖脚本插件id.
+ **Return Type**: **List<String>**
+ **Return Desc**: 必要依赖脚本插件id.
+ **Usage**: `self:getDependents()`

|Name|Type|Description|
|-|-|-|

### self:getConfigPath
+ **Description**:  获取脚本插件的配置目录.
+ **Return Type**: **File**
+ **Return Desc**: 配置目录File对象.
+ **Usage**: `self:getConfigPath()`

|Name|Type|Description|
|-|-|-|

### self:getPluginPath
+ **Description**:  获取脚本插件所在的目录.
+ **Return Type**: **File**
+ **Return Desc**: 脚本插件所在的目录.
+ **Usage**: `self:getPluginPath()`

|Name|Type|Description|
|-|-|-|

### self:getRequirePath
+ **Description**:  方便require方法获取脚本插件的模块路径.
+ **Return Type**: **String**
+ **Return Desc**: 返回脚本插件require所认可的模块路径.
+ **Usage**: `self:getRequirePath(module:String)`

|Name|Type|Description|
|-|-|-|
|module|**String**|模块名称|
### self:getLogger
+ **Description**:  获取Logger.
+ **Return Type**: **Logger**
+ **Return Desc**: 返回Logger.
+ **Usage**: `self:getLogger()`

|Name|Type|Description|
|-|-|-|

### self:getRunType
+ **Description**:  获取运行模式.
+ **Return Type**: **RunType**
+ **Return Desc**: 当前插件的运行模式.
+ **Usage**: `self:getRunType()`

|Name|Type|Description|
|-|-|-|
