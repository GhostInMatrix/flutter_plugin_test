package io.flutter.plugins

import android.os.Build
import android.util.Log
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.PluginRegistry


class FlutterPluginTestNewPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when (call.method) {
            "getPlatformVersion" -> {
                Log.e("onMethodCall", call.method)
                result.success("Android " + Build.VERSION.RELEASE)
            }
            "get222" -> {
                Log.e("onMethodCall222", call.method)
                result.success("Android2222 " + Build.VERSION.RELEASE)
            }
            else -> {
                result.notImplemented()
            }
        }
    }


    //// FlutterPlugin 的两个 方法
    override fun onAttachedToEngine(flutterPluginBinding: FlutterPluginBinding) {
        Log.e("onAttachedToEngine", "onAttachedToEngine")
        channel = MethodChannel(flutterPluginBinding.flutterEngine.dartExecutor, CHANNEL)
        channel!!.setMethodCallHandler(this)
    }

    override fun onDetachedFromEngine(binding: FlutterPluginBinding) {
        Log.e("onDetachedFromEngine", "onDetachedFromEngine")
    }

    ///activity 生命周期
    override fun onAttachedToActivity(activityPluginBinding: ActivityPluginBinding) {
        Log.e("onAttachedToActivity", "onAttachedToActivity")
    }

    override fun onDetachedFromActivityForConfigChanges() {
        Log.e("onDetachedActivityFCC", "onDetachedFromActivityForConfigChanges")
    }

    override fun onReattachedToActivityForConfigChanges(activityPluginBinding: ActivityPluginBinding) {
        Log.e("onReattachedActivityFCC", "onReattachedToActivityForConfigChanges")
    }

    override fun onDetachedFromActivity() {
        Log.e("onDetachedFromActivity", "onDetachedFromActivity")
    }

    companion object {
        private var channel: MethodChannel? = null
        const val CHANNEL = "flutter_plugin_test_new"
        fun registerWith(register: PluginRegistry.Registrar) {
            Log.e("registerWith", "registerWith")
            channel = MethodChannel(register.messenger(), CHANNEL)
            channel!!.setMethodCallHandler(FlutterPluginTestNewPlugin())
        }

        fun registerWith(engine: FlutterEngine) {
            channel = MethodChannel(engine.dartExecutor.binaryMessenger, CHANNEL)
            channel!!.setMethodCallHandler(FlutterPluginTestNewPlugin())
        }
    }
}