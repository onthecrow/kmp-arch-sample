import SwiftUI
import shared

@propertyWrapper struct StateValue<T : AnyObject>: DynamicProperty {
    @ObservedObject
    private var obj: ObservableValue<T>
    
    var wrappedValue: T { obj.value }
    
    var projectedValue: Binding<T> {
        .init { obj.value }
    }
    
    init(_ value: Value<T>) {
        obj = ObservableValue(value)
    }
}
