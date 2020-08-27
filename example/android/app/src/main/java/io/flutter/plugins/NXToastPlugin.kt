package io.flutter.plugins

import android.app.Application
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.example.example.MyApplication
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.PluginRegistry

class NXToastPlugin : FlutterPlugin, MethodChannel.MethodCallHandler {

    companion object {
        private var engine: FlutterEngine? = null
        private var channel: MethodChannel? = null
        const val CHANNEL = "flutter_plugin_nxtoast"

        fun registerWith(engine: FlutterEngine) {
            channel = MethodChannel(engine.dartExecutor.binaryMessenger, CHANNEL)
            channel!!.setMethodCallHandler(NXToastPlugin())
        }
    }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        Log.e("onMethodCall222", call.method)

        when (call.method) {
            "get222" -> {
                result.success("Android2222 " + Build.VERSION.RELEASE)
            }
            "nxToast" -> {
                Toast.makeText(MyApplication.instance!!, "Mother Fxxker!!", Toast.LENGTH_LONG).show()
            }
            else -> {
                result.notImplemented()
            }
        }
    }
}