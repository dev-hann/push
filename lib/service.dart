import 'package:flutter/services.dart';

class Service {
  final platform =
      const MethodChannel('com.example.method_channel_example/message');

  void invoke() async {
    final result = await platform.invokeMethod("incoming");
    print(result);
  }
}
