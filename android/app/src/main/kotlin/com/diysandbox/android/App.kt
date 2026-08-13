package com.diysandbox.android

import android.app.Application
import rikka.shizuku.ShizukuProvider

/** 自定义 Application (预留)。WebUI 使用系统 WebView, 无需额外内核初始化。 */
class App : Application() {

    init {
        // 禁用 ShizukuProvider.onCreate 里的 Sui(类 root 方案)自动初始化。
        // 本应用只依赖 Shizuku server 注入 binder, 且未装 Sui 时应优雅降级,
        // 避免任何潜在异常导致进程启动闪退。init 块先于 provider.onCreate 执行。
        ShizukuProvider.disableAutomaticSuiInitialization()
    }
}
