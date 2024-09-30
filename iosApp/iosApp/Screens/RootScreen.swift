import SwiftUI
import shared

extension ChildCreated: Identifiable {}

struct RootScreen: View {
    private let root: Root
    
    @StateValue
    private var childStack: ChildStack<AnyObject, RootChild>
    
    @StateValue
    private var childSlot: ChildSlot<AnyObject, RootSlotChild>
    
    init(root: Root) {
        self.root = root
        self._childStack = .init(root.childStack)
        self._childSlot = .init(root.childSlot)
    }
    
    var body: some View {
        StackView(
            stackValue: _childStack,
            getTitle: { child in
                switch child {
                    case child as RootChild.FullScreenChild:
                        "Feature 5"
                    default:
                        "KMP Arch Sample"
                }
            },
            onBack: root.onBackClicked,
            childContent: { child in
                Group {
                    switch child {
                        case let child as RootChild.FullScreenChild:
                            Text("Feature 5")
                        case let child as RootChild.TabsChild:
                            TabsScreen(component: child.component)
                        default:
                            EmptyView()
                    }
                }
                .toolbar {
                    ToolbarItemGroup(placement: .topBarTrailing) {
                        Button(action: root.onSettingsClick) {
                            Image(systemName: "gearshape.fill")
                        }
                        
                        Button(action: root.onEditClick) {
                            Text("Edit")
                        }
                    }
                }
            }
        )
        .sheet(
            item: $childSlot.child,
            onDismiss: {
                root.dismissSlotChild()
            },
            content: { child in
                NavigationStack {
                    let instance = child.instance
                    switch instance {
                        case let feature4 as RootSlotChild.Feature4Child:
                            Text("Feature 4")
                                .toolbar {
                                    ToolbarItem(placement: .navigationBarLeading) {
                                        Button {
                                            root.dismissSlotChild()
                                        } label: {
                                            HStack {
                                                Image(systemName: "chevron.backward")
                                                Text("Back")
                                            }
                                        }
                                    }
                                }
                        default:
                            EmptyView()
                    }
                }
                .presentationDetents([.medium])
            }
        )
    }
}
