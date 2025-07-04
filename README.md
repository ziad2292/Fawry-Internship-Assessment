# 🛒 Fawry Quantum Internship Challenge — E-Commerce System

This repository contains my solution for the **Fawry Rise Journey Full Stack Development Internship Challenge**, where I designed and implemented a simple yet robust **E-Commerce System** in Java.

---

## 📌 Problem Overview

The system simulates a basic online shopping experience with support for:
- Products with expiration and/or shipping behavior
- Cart operations with quantity checks
- Checkout with balance verification, shipping calculation, and error handling

---

## ✅ Features

### 🧾 Product Modeling
- Every product has a `name`, `price`, and `quantity`
- Products may optionally:
  - Be **expirable** (e.g. Cheese, Biscuits)
  - Require **shipping with weight** (e.g. TV, Cheese)

### 🛍 Cart Functionality
- Add products with custom quantity (ensures availability)
- Prevents adding expired or out-of-stock items

### 💳 Checkout Process
- Calculates:
  - Subtotal of all products
  - Total shipping fees
  - Total paid amount
  - Remaining customer balance
- Handles:
  - Empty cart
  - Insufficient customer balance
  - Expired or unavailable items

### 📦 ShippingService Integration
- Collects all shippable items
- Accepts a list of objects implementing:
 
