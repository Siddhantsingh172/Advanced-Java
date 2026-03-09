<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<h2>Cart Summary</h2>

<c:forEach var="item" items="${items}">
    ${item.product.name} -
    Qty: ${item.quantity} -
    ₹${item.product.price * item.quantity}
    <br/>
</c:forEach>

<h3>Total: ₹${total}</h3>

<a href="products">Back to Products</a>