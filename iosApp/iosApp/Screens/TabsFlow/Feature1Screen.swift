import SwiftUI
import shared

struct Feature1Screen: View {
    let component: Feature1Component
    
    @StateFlow
    var state: Feature1UiState
    
    @StateValue
    var childStack: ChildStack<AnyObject, Feature1Child>
    
    init(component: Feature1Component) {
        self.component = component
        self._state = .init(component.state)
        self._childStack = .init(component.childStack)
    }
    
    var body: some View {
        VStack(spacing: 50.0) {
            let instance = childStack.active.instance
            
            switch instance {
                case _ as Feature1Child.FirstChild:
                    Text("Feature 1: First Subscreen")
                case _ as Feature1Child.SecondChild:
                    Text("Feature 1: Second Subscreen")
                default:
                    EmptyView()
            }
            
            Button(buttonLabel) {
                switch instance {
                    case _ as Feature1Child.FirstChild:
                        component.onNextClick()
                    case _ as Feature1Child.SecondChild:
                        component.onBackPressed()
                    default:
                        break
                }
            }
        }
    }
    
    var buttonLabel: String {
        switch childStack.active.instance {
            case _ as Feature1Child.FirstChild:
                "Go Next"
            case _ as Feature1Child.SecondChild:
                "Go Back"
            default:
                ""
        }
    }
}
