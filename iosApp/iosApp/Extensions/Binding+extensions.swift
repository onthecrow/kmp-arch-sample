import SwiftUI

extension Binding {
    subscript<T>(dynamicMember keyPath: KeyPath<Value, T>) -> Binding<T> {
        .init {
            wrappedValue[keyPath: keyPath]
        } set: { newValue in
            if let writableKeyPath = keyPath as? WritableKeyPath {
                wrappedValue[keyPath: writableKeyPath] = newValue
            }
        }
    }
}

extension Binding {
    func bind(_ set: @escaping (Value) -> Void) -> Binding<Value> {
        .init(get: { wrappedValue }, set: { set($0) })
    }
    
    func map<T>(
        get: @escaping (Value) -> T,
        set: ((T) -> Value)? = nil
    ) -> Binding<T> {
        .init {
            get(wrappedValue)
        } set: { newValue in
            if let set {
                wrappedValue = set(newValue)
            }
        }
    }
    
    init(get: @escaping () -> Value) {
        self.init(get: get, set: { _ in })
    }
}
