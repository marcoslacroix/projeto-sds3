import { Seller } from "./seller"

export type SaleSum = {
    sellerName: string,
    sum: number
}

export type SaleSucess = {
    sellerName: string,
    visited: number,
    deals: number
}

export type SalePage = {
    content?: Sale[],
    totalPages: number,
    totalElements: number,
    last: boolean,
    number: number,
    size?: number,
    numberOfElements?: number,
    first: boolean,
    empty?: boolean
}

export type Sale = {
    "id": number,
    "visited": number,
    "deals": number,
    "amount": number,
    "date": string,
    "seller": Seller
}