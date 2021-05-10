# docker的学习

## docker简介

​	Docker是基于Go语言实现的云开源项目。
​	Docker的主要目标是“Build，Ship and Run Any App,Anywhere”，也就是通过对应用组件的封装、分发、部署、运行等生命周期的管理，使用户的APP（可以是一个WEB应用或数据库应用等等）及其运行环境能够做到“一次封装，到处运行”。

![docker示意图](./images/01.jpeg)

​	Linux 容器技术的出现就解决了这样一个问题，而 Docker 就是在它的基础上发展过来的。将应用运行在 Docker 容器上面，而 Docker 容器在任何操作系统上都是一致的，这就实现了跨平台、跨服务器。只需要一次配置好环境，换到别的机子上就可以一键部署好，大大简化了操作

### docker下载

- Docker官网 http://www.docker.com
- Docker Hub官网: https://hub.docker.com/

## docker安装

### docker的基本组成

- 镜像

  Docker 镜像（Image）就是一个*只读*的模板。镜像可以用来创建 Docker 容器，**一个镜像可以创建很多容器**。

  ![镜像](./images/02.png)

- 容器

  Docker 利用容器（Container）独立运行的一个或一组应用。**容器是用镜像创建的运行实例**。

  它可以被启动、开始、停止、删除。每个容器都是相互隔离的、保证安全的平台。

  可以把容器看做是一个简易版的 Linux 环境（包括root用户权限、进程空间、用户空间和网络空间等）和运行在其中的应用程序。

  容器的定义和镜像几乎一模一样，也是一堆层的统一视角，唯一区别在于容器的最上面那一层是可读可写的。

- 仓库

  **仓库（Repository）是集中存放镜像文件的场所**。
  仓库(Repository)和仓库注册服务器（Registry）是有区别的。仓库注册服务器上往往存放着多个仓库，每个仓库中又包含了多个镜像，每个镜像有不同的标签（tag）。

  仓库分为公开仓库（Public）和私有仓库（Private）两种形式。
  最大的公开仓库是 Docker Hub(https://hub.docker.com/)，
  存放了数量庞大的镜像供用户下载。国内的公开仓库包括阿里云 、网易云 等

### docker安装

​	本文只针对CentOS7及以上版本安装，其他操作系统请自行百度

	* 确认版本在CentOS7及以上版本 

```linux
cat /etc/redhat-release
```

	* yum安装gcc相关

```LINUX
yum -y install gcc
yum -y install gcc-c++
```

	* 卸载旧版本

```
yum -y remove docker docker-common docker-selinux docker-engine
```

- 安装需要的软件包

```
yum install -y yum-utils device-mapper-persistent-data lvm2
```

- 设置stable镜像仓库

```
yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```

- 更新yum软件包索引

```
yum makecache fast
```

- 安装docker ce

```
yum -y install docker-ce
```

- 启动docker

```
systemctl start docker
```

- 测试

```
docker version
docker run hello-world
```

- 配置镜像加速

```
mkdir -p /etc/docker
vim  /etc/docker/daemon.json
systemctl daemon-reload
systemctl restart docker
```

