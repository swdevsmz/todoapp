# AlmaLinuxOS9.4

## VMセットアップ


* [ここ](https://almalinux.org/ja/get-almalinux/) からMinimal ISOをダウンロード

* rootパスワードの設定、SSH許可

* ネットワーク・ホスト名の設定

* インストール先はデフォルト設定

* ソフトウェアの選択は追加せずデフォルトのまま


## OSセットアップ

* インストール済みパッケージの更新
```
sudo yum update
```
* システム全体のアップグレード
```
sudo yum upgrade
```

* Dockerリポジトリ追加のためyum-utilsを追加
```
sudo yum install -y yum-utils
```
* Dockerリポジトリの追加
```
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
```
* Dockerリポジトリの追加を確認
```
sudo yum repolist | grep docker
```

* Docker関連ツールのインストール
```
sudo yum install \
    docker-ce \
    docker-ce-cli \
    containerd.io \
    docker-buildx-plugin \
    docker-compose-plugin
```

* Dockerサービスの起動
```
sudo systemctl start docker
```
* Dockerサービスの自動起動
```
sudo systemctl enable docker
```
* docker-compose.ymlのサンプル
```
version: '3'
services:
  web:
    image: nginx:alpine
    ports:
      - "8080:80"
  redis:
    image: redis:alpine
```

* 監視ツールのsysstatをインストール
```
sudo yum install sysstat
```

* sysstat用の設定を作成
```
sudo vi /etc/cron.d/sysstat
```
```
# Run system activity accounting tool every 10 minutes
*/10 * * * * root /usr/lib64/sa/sa1 1 1
# 0 * * * * root /usr/lib64/sa/sa1 600 6 &
# Generate a daily summary of process accounting at 23:53
53 23 * * * root /usr/lib64/sa/sa2 -A
```
* sysstatサービスの実行
```
sudo systemctl start sysstat 
```
* sysstatの自動起動
```
sudo systemctl enable sysstat 
```






### そのたメモ

https://gigazine.net/news/20240327-linux-crisis-tools/

topコマンド

topコマンドで現在動作しているプロセスを一覧で確認できます。

freeコマンド

freeコマンドを実行すると、topコマンドの実行結果の4, 5行目の詳細を確認することができます。
-mオプションでメガバイト表示になります。

psコマンド

プロセスの状態を確認し、サーバにどのような処理が負荷をかけているのかをみることができます。
-aux -efオプションとよく一緒に使われます。
これらのオプションの実行結果は大体同じです。


オプション	表示内容
a	端末操作のプロセス
u	CPUやメモリの使用率など
x	端末操作以外のプロセス


jobsコマンド
実行中のジョブを表示することができます。

vmstat

vmstatは多くの環境で標準でインストールされており、表示項目もメモリ・スワップ・IO・CPUと一通りそろっている。

vmstat 2で2秒ごとに表示される。
-tをつけると時刻も表示される。


コマンド	用途	収録パッケージ
vmstat 2	システム全体の負荷を見るならこれ。2で2秒ごと	procps
top	CPUやメモリを食っているプロセスを特定したいならこれ	procps
sar	過去の負荷の履歴をみたいならこれ	sysstat
mpstat -P ALL 1	CPUコアごとの負荷を見るならこれ	sysstat
dstat -taf	標準ではインストールされていないが、一番便利なコマンド	dstat
free -m	メモリ。-mでメガバイト単位	procps
iostat -dmxt 1	IO状況	sysstat