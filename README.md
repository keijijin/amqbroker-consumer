# AMQBroker Consumer

このプロジェクトは、AMQBrokerからメッセージを受信するConsumerプログラムを提供します。このプログラムはJava言語で書かれており、特定のキューからメッセージを非同期に受信する機能を持っています。

## 技術スタック
- AMQBroker
- Java

## 前提条件

このプログラムを実行する前に、以下の要件を満たしていることを確認してください：
* Javaがインストールされていること
* Mavenがインストールされていること
* AMQBrokerサーバーが稼働していること

## セットアップ手順

プロジェクトをローカル環境にセットアップするには、以下の手順に従ってください：

```bash
git clone https://github.com/keijijin/amqbroker-consumer.git
cd amqbroker-consumer
mvn clean package
```
これにより、必要な依存関係がインストールされ、プロジェクトがビルドされます。

## 使用方法
アプリケーションを実行するには、次のコマンドを実行します：
```bash
java -jar target/amqbroker-consumer-1.0.0-SNAPSHOT-jar-with-dependencies.jar [キュー名]
```

ここで [キュー名] はオプショナルで、指定されない場合はデフォルトのキューにメッセージが送信されます。例えば VTC.A.ny.customer.info キューからメッセージを受信する場合は、次のようにします：
```bash
java -jar target/amqbroker-consumer-1.0.0-SNAPSHOT-jar-with-dependencies.jar VTC.A.ny.customer.info
```

このコマンドは、指定されたキューからAMQBrokerによって送信されたメッセージを受信し、処理します。
