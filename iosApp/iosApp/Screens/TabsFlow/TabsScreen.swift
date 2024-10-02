import SwiftUI
import shared

enum TabComponent: Hashable {
    case feature1
    case feature2
    case feature3
    
    init(_ component: TabsComponentChild) {
        switch component {
            case _ as TabsComponentChild.Feature1Child:
                self = .feature1
            case _ as TabsComponentChild.Feature2Child:
                self = .feature2
            case _ as TabsComponentChild.Feature3Child:
                self = .feature3
            default:
                self = .feature1
        }
    }
}

struct TabsScreen: View {
    let component: TabsComponent
    
    @StateValue
    var stack: ChildStack<AnyObject, TabsComponentChild>
    
    init(component: TabsComponent) {
        self.component = component
        self._stack = .init(component.stack)
    }
    
    var body: some View {
        TabView(selection: $stack.map {TabComponent($0.active.instance)}
            .bind { feature in
                switch feature {
                    case .feature1:
                        component.onFeature1TabClicked()
                    case .feature2:
                        component.onFeature2TabClicked()
                    case .feature3:
                        component.onFeature3TabClicked()
                }
            }
        ) {
            Group {
                if case let feature1 = stack.active.instance as? TabsComponentChild.Feature1Child,
                   let feature1 {
                    Feature1Screen(component: feature1.component)
                } else {
                    Spacer()
                }
            }
            .tag(TabComponent.feature1)
            .tabItem {
                VStack {
                    Image(systemName: "printer")
                    Text("Feature 1")
                }
            }
            
            Text("Feature 2")
                .tag(TabComponent.feature2)
                .tabItem {
                    VStack {
                        Image(systemName: "scanner.fill")
                        Text("Feature 2")
                    }
                }
            
            Text("Feature 3")
                .tag(TabComponent.feature3)
                .tabItem {
                    VStack {
                        Image(systemName: "desktopcomputer")
                        Text("Feature 3")
                    }
                }
        }
    }
}
