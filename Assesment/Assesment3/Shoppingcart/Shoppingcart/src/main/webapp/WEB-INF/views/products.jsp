<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<h2>Product List</h2>

<c:forEach var="p" items="${products}">
    <form action="add" method="post">
        ${p.name} - ₹${p.price}
        <input type="hidden" name="productId" value="${p.id}"/>
        Quantity: <input type="number" name="quantity"/>
        <button type="submit">Add to Cart</button>
    </form>
    <br/>
</c:forEach>

<a href="cart">View Cart</a>