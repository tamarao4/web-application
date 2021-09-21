import { TestBed } from '@angular/core/testing';

import { NeregistrovaniKorisnikService } from './neregistrovani-korisnik.service';

describe('NeregistrovaniKorisnikService', () => {
  let service: NeregistrovaniKorisnikService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NeregistrovaniKorisnikService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
