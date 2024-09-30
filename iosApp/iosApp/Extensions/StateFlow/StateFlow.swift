import SwiftUI
import shared

@propertyWrapper struct StateFlow<T : AnyObject>: DynamicProperty {
    @ObservedObject
    private var obj: ObservableStateFlow<T>
    
    var wrappedValue: T { obj.value }
    
    var projectedValue: Binding<T> {
        .init { obj.value }
    }
    
    init(_ flow: CoreAnyStateFlow<T>) {
        obj = ObservableStateFlow(flow)
    }
}
