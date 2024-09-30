import shared
import SwiftUI

final class ObservableStateFlow<T: AnyObject>: ObservableObject {
    private let observableFlow: CoreAnyStateFlow<T>
    @Published var value: T
    private var cancellation: (any CoreCancellable)?
    
    init(_ flow: CoreAnyStateFlow<T>) {
        observableFlow = flow
        self.value = flow.value
        cancellation = flow.collect { [weak self] value in self?.value = value }
    }
    
    deinit {
        cancellation?.cancel()
    }
}
