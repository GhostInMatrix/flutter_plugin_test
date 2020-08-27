package com.example.example

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.FlutterPluginTestNewPlugin
import io.flutter.plugins.NXToastPlugin

class MainActivity : FlutterActivity() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        FlutterPluginTestNewPlugin.registerWith(flutterEngine)
        NXToastPlugin.registerWith(flutterEngine)
    }

}
