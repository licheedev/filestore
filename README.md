# filestore

### [使用putty远程管理vps](http://www.tennfy.com/2022.html)

### 修改SSH端口
```bash
# 修改文件
vim /etc/ssh/sshd_config
# 在文件的最后面，修改Port的值，然后 重启ssh服务
# centos
service sshd restart
# debian
service ssh restart 
```

### CentOS配置shadowsocks-libev
```bash
wget --no-check-certificate https://raw.githubusercontent.com/licheetec/filestore/master/shadowsocks-libev.sh
chmod +x shadowsocks-libev.sh
./shadowsocks-libev.sh 2>&1 | tee shadowsocks-libev.log
```
出处：[**秋水逸冰**](http://teddysun.com/357.html/comment-page-6)

### CentOS配置V*N
```bash
wget --no-check-certificate https://raw.githubusercontent.com/licheetec/filestore/master/openvps_vpn_centos-5-6.sh
chmod a+x openvps_vpn_centos-5-6.sh
bash openvps_vpn_centos-5-6.sh
```
出处：[**Zuike 技术博客**](http://www.cnblogs.com/zuike/articles/4167182.html)

### CentOS配置goagent-php
```bash
# 升级
yum update

# 安装apache,并设置开机启动
yum install httpd
chkconfig --levels 35 httpd on
service httpd start

# 安装php
yum install php

# 搭建SSL,让apache支持https
yum install mod_ssl

# 添加goagent-php文件
cd /var/www/html/
wget --no-check-certificate https://raw.githubusercontent.com/licheetec/filestore/master/init-goagent-php.sh
chmod a+x init-goagent-php.sh
bash init-goagent-php.sh
rm init-goagent-php.sh

# 重启服务
service httpd restart
```
出处：[**Thinking in code**](http://www.cnblogs.com/cryinstall/archive/2011/09/25/2189900.html)
goagent配置见：[**FAQ 11**](https://github.com/goagent/goagent/blob/wiki/FAQ.md) 和 [**Configurations**](https://github.com/goagent/goagent/blob/wiki/ConfigIntroduce.md.ini)