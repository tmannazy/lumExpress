package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.repositories.CartRepository;
import africa.semicolon.lumexpress.services.serviceinterface.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

}
