我们要编写一个待办事项管理的软件，你可以看我下面给出的需求，它是以命令行应用的方式存在的。

第一阶段：基本功能添加 Todo 项。

添加 Todo 项。

```shell

todo add <item>


1. <item>


Item <itemIndex> added
```

完成 Todo 项。

```shell script

todo done <itemIndex>


Item <itemIndex> done.
```

查看 Todo 列表，缺省情况下，只列出未完成的 Todo 项。

```shell script

todo list


1. <item1>
2. <item2>


Total: 2 items
```

使用 all 参数，查看所有的 Todo 项。

```shell script

todo list --all


1. <item1>
2. <item2>
3. [Done] <item3>


Total: 3 items, 1 item done
```

要求：Todo 项存储在本地文件中；Todo 项索引逐一递增

第二阶段：支持多用户

用户登录

```shell script

todo login -u user
Password: 


Login success!
```

用户退出。

```shell script

todo logout


Logout success!
```

要求：只能看到当前用户的 Todo 列表；同一个用户的 Todo 项索引逐一递增；当前用户信息存储在配置文件中 ~/.todo-config。

第三阶段：支持 Todo 列表导入和导出

Todo 列表导出。

```shell script

todo export > todolist

```

Todo 列表导入。

```shell script

todo import -f todolist
```

第四阶段：支持数据库持久化

在配置文件中，配置数据库连接信息。

初始化数据库。

```shell script

todo init
```

要求：没有数据库的情况下，使用本地文件；在有数据库的情况下，使用数据库；在本地文件已经存在的情况，将本地信息导入到数据库中。

以上给出的是最基本的需求，你可以根据自己的实际编码情况，适当补充一些细节，比如，相应的错误提示。你可以用自己最熟悉的程序设计语言、按照自己最习惯的方式编写代码，并在 Github 上以公开仓库的方式提交自己的代码，将仓库链接贴在这节课的留言区下，我会顺着链接找到你的仓库，去查看你写的代码。

为了方便代码的阅读，请你按如下要求编写你的代码：在项目的 README 文件中，写出如何构建和执行你的应用；需求分成四个阶段，请你按顺序依次完成每个阶段的需求；每完成一个阶段的代码，创建一个 tag，tag 名称分别为 todo-phase-1、todo-phase-2、todo-phase-3、todo-phase-4