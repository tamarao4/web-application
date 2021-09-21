import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PravoPristupaComponent } from './pravo-pristupa.component';

describe('PravoPristupaComponent', () => {
  let component: PravoPristupaComponent;
  let fixture: ComponentFixture<PravoPristupaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PravoPristupaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PravoPristupaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
