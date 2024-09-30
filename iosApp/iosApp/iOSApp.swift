import SwiftUI

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            RootView { rootHolder in
                RootScreen(root: rootHolder.root)
            }
        }
    }
}
