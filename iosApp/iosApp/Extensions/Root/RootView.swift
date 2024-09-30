import SwiftUI
import shared

struct RootView<Content: View>: View {
    let content: (RootHolder) -> Content
    
    @StateObject private var rootHolder = RootHolder()
    
    @Environment(\.scenePhase)
    var scenePhase: ScenePhase
    
    var body: some View {
        content(rootHolder)
            .onChange(of: scenePhase) { newPhase in
                switch newPhase {
                    case .background: LifecycleRegistryExtKt.stop(rootHolder.lifecycle)
                    case .inactive: LifecycleRegistryExtKt.pause(rootHolder.lifecycle)
                    case .active: LifecycleRegistryExtKt.resume(rootHolder.lifecycle)
                    @unknown default: break
                }
            }
    }
}
