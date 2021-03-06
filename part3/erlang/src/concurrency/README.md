`Erlang` 中的并行编程需要具有以下基本原理或过程。
列表包括以下原则-

- pid=spawn(Fun)

创建一个评估 `Fun` 的新并发进程。新进程与调用方并行运行。


- Pid ! Message
 
向标识符为 `Pid` 的进程发送消息。消息发送是异步的。
发送者不等待，而是继续其所做的事情。 `！`称为发送运算符。

- Receive…end

接收已发送到进程的消息。

语法：

```erlang
receive
Pattern1 [when Guard1] ->
Expressions1;
Pattern2 [when Guard2] ->
Expressions2;
...
End
```
当消息到达进程时，系统尝试将其与 `Pattern1` 匹配（可能带有 `Guard1` ）。
如果成功，它将评估 `Expressions1`。
如果第一个模式不匹配，则尝试使用 `Pattern2`，依此类推。
如果没有任何一种模式匹配，则保存该消息以供以后处理，然后该过程等待下一条消息。


### 最大进程数

并发中，重要的是确定系统上允许的最大进程数。
然后，您应该能够了解系统上可以同时执行多少个进程。

在任何具有良好处理能力的机器上，上述两个最大功能都会通过。
以下是上述程序的输出示例。

### 延时/接收    

有时，· 语句可能会永远等待永远不会出现的消息。
这可能是出于多种原因。
例如，我们的程序中可能存在逻辑错误，或者要向我们发送消息的进程在发送消息之前可能已崩溃。
为避免此问题，我们可以将y延时添加到接收语句。
这设置了进程等待接收消息的最长时间。

语法：

```erlang
receive 
Pattern1 [when Guard1] -> 
Expressions1; 

Pattern2 [when Guard2] ->
Expressions2; 
... 
after Time -> 
Expressions 
end
```

### 选择性接收

`Erlang` 中的每个进程都有一个关联的邮箱。
当您向该进程发送消息时，该消息将放入邮箱中。
仅当程序评估接收语句时，才检查此邮箱。
以下是选择性接收语句的一般语法。

```erlang
receive 
Pattern1 [when Guard1] ->
Expressions1; 

Pattern2 [when Guard1] ->
Expressions1; 
... 
after 
Time ->
ExpressionTimeout 
end
```

这就是上面的接收语句的工作方式:

- 当我们输入一个 `receive` 语句时，我们将启 动一个计时器（但前提是表达式中存在一个 `after` 节）。
- 拿邮箱中的第一条消息，然后尝试将其与Pattern1，Pattern2等匹配。
如果匹配成功，则会从邮箱中删除该邮件，并评估模式后面的表达式。
- 如果 `receive` 语句中的任何模式都不匹配邮箱中的第一条消息，则将从邮箱中删除第一条消息并将其放入“保存队列”。
然后尝试邮箱中的第二条消息。
重复此过程，直到找到匹配的消息或检查了邮箱中的所有消息为止。

- 如果邮箱中的所有邮件都不匹配，则该过程将被挂起，并将在下次将新邮件放入邮箱中时重新安排执行时间。
请注意，当收到新消息时，保存队列中的消息将不重新匹配；
仅匹配新消息。

- 匹配邮件后，已放入保存队列中的所有邮件将按照到达过程的顺序重新输入到邮箱中。
如果设置了计时器，则将其清除。

- 如果等待消息时计时器已消逝，请评估表达式 `ExpressionsTimeout` 并将所有保存的消息按到达过程的顺序放回邮箱。


