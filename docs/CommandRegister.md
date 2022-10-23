
### luaBukkit.command:registerCommand
+ **Description**:  注册一个指令.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.command:registerCommand(command:String, id:String)`

|Name|Type|Description|
|-|-|-|
|command|**String**|要注册的指令.|
|id|**String**|闭包id.|
### luaBukkit.command:dispatch
+ **Description**:  指令分发.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.command:dispatch(sender:CommandSender, command:Command, label:String, args:String[])`

|Name|Type|Description|
|-|-|-|
|sender|**CommandSender**|指令发送者.|
|command|**Command**|指令.|
|label|**String**|指令.|
|args|**String[]**|指令.|